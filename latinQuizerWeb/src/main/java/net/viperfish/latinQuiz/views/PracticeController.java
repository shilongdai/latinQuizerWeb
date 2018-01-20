package net.viperfish.latinQuiz.views;

import java.util.Date;
import java.util.Map;
import java.util.concurrent.TimeUnit;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import net.viperfish.latinQuiz.core.Answer;
import net.viperfish.latinQuiz.core.Question;
import net.viperfish.latinQuiz.core.SingleTextualAnswer;
import net.viperfish.latinQuiz.core.Tense;
import net.viperfish.latinQuiz.errors.InsufficientWordBankException;
import net.viperfish.latinQuiz.quizers.VerbQuizerService;

@Controller
@RequestMapping(value = "/practice")
public class PracticeController {

	@Autowired
	private VerbQuizerService verbService;
	private static final VerbStartPracticeForm DEFAULT;

	static {
		DEFAULT = new VerbStartPracticeForm();
		for (int i = 0; i < 6; ++i) {
			DEFAULT.getConjugations().add(i);
		}
		for (Tense t : Tense.values()) {
			DEFAULT.getTenses().add(t);
		}
	}

	public PracticeController() {
	}

	@RequestMapping(method = RequestMethod.GET)
	public String startPracticePage(Map<String, Object> model) {
		model.put("verbForm", DEFAULT);
		return "practice";
	}

	@RequestMapping(value = "verb", method = RequestMethod.POST)
	public String startVerbPractice(@ModelAttribute("verbForm") @Validated VerbStartPracticeForm verbForm,
			BindingResult bindingResult, HttpSession session, Map<String, Object> model) {
		session.setAttribute("review", false);
		if (bindingResult.hasErrors()) {
			model.put("verbForm", verbForm);
			return "practice";
		}
		try {
			Integer[] selectedConjugations = verbForm.getConjugations()
					.toArray(new Integer[verbForm.getConjugations().size()]);
			Question[] generated = verbService.generateQuestions(verbForm.getAmount(), selectedConjugations,
					verbForm.getTenses());
			Answer[] answers = new Answer[generated.length];
			for (int i = 0; i < answers.length; ++i) {
				answers[i] = new SingleTextualAnswer();
			}
			session.setAttribute("questions", generated);
			session.setAttribute("userAnswers", answers);
			session.setAttribute("begin", new Date().getTime());
			return "redirect:/practice/verb/0";
		} catch (InsufficientWordBankException e) {
			bindingResult.reject("amount", "error.verbForm");
			model.put("verbForm", verbForm);
			return "practice";
		}
	}

	@RequestMapping(value = "verb/{count}/singleTextAnswer", method = RequestMethod.POST)
	public String answerVerbPractice(SingleTextualAnswer singleTextualAnswer, HttpSession session,
			@PathVariable("count") int count) {
		Answer[] answers = (Answer[]) session.getAttribute("userAnswers");
		if (answers == null) {
			return "redirect:/practice";
		}
		answers[count] = singleTextualAnswer;
		if (count == answers.length - 1) {
			if (!(boolean) session.getAttribute("review")) {
				session.setAttribute("end", new Date().getTime());
			}
			return "redirect:/practice/verb/report";
		}
		return "redirect:/practice/verb/" + (count + 1);
	}

	@RequestMapping(value = "verb/{count}", method = RequestMethod.GET)
	public String getVerbPractice(HttpSession session, @PathVariable("count") int count, Map<String, Object> model) {
		Question[] questions = (Question[]) session.getAttribute("questions");
		Answer[] answers = (Answer[]) session.getAttribute("userAnswers");
		if (answers == null) {
			return "redirect:/practice";
		}
		model.put("current", count);
		model.put("count", questions.length);
		model.put("question", questions[count]);
		model.put("answer", answers[count]);
		if ((boolean) session.getAttribute("review")) {
			model.put("reviewing", true);
		}
		return "multipleChoice";
	}

	@RequestMapping(value = "verb/report", method = RequestMethod.GET)
	public String verbReport(Map<String, Object> model, HttpSession session) {
		Question[] questions = (Question[]) session.getAttribute("questions");
		Answer[] answers = (Answer[]) session.getAttribute("userAnswers");
		if (answers == null) {
			return "redirect:/practice";
		}
		int total = answers.length;
		int correct = 0;
		for (int i = 0; i < answers.length; ++i) {
			if (questions[i].getAnswer().equals(answers[i])) {
				correct += 1;
			}
		}
		int incorrect = total - correct;
		double score = ((double) correct) / ((double) total) * 100.0;
		long timestampDelta = (long) session.getAttribute("end") - (long) session.getAttribute("begin");
		String time = String.format("%d min, %d sec", TimeUnit.MILLISECONDS.toMinutes(timestampDelta),
				TimeUnit.MILLISECONDS.toSeconds(timestampDelta)
						- TimeUnit.MINUTES.toSeconds(TimeUnit.MILLISECONDS.toMinutes(timestampDelta)));
		model.put("report", new VerbReport(total, correct, incorrect, (int) score, time));
		session.setAttribute("review", true);
		return "verbReport";
	}

}
