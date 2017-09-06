package is.hi.byrjun.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

/**
 * @author Sævar Ingi Sigurðsson <sis108@hi.is>
 * 
 * Controller that dictates what is done when the user or UI sends an instruction.
 */

@Controller
@RequestMapping("/demo") // Request Mapping er gerð fyrir klasann til að slóðin byrji á /demo fyrir allar skipanir 
public class DemoController {


    /**
     * Sýnidæmi
     * @return
     */
    @RequestMapping("/page")
    public String demoPage(){
        return "demo/demo"; // skilar .jsp skrá sem er /webapp/WEB-INF/vefvidmot/demo/demo.jsp
                            // skoðið application.properties til að sjá hvernig slóðin er sett
    }
    
    /**
     * Spyr hvað notandinn heitir.
     * 
     * @return
     */
    @RequestMapping("/spyrjaNotanda")
    public String spyrjaNotanda() {
    		return "demo/hvadaNotandi";
    }

    /**
     * Tekur við nafni frá notanda og birtir "Góðan daginn ${nafn}".
     * @param nafn - Nafn á notanda.
     * @param model - Model með attributes.
     * @return
     */
    @RequestMapping(value="/hver", method=RequestMethod.POST)
    public String hver(@RequestParam(value="nafn", required=false)String nafn, ModelMap model) {
    		model.addAttribute("nafn", nafn);
    		return "demo/synaNotandi";
    }

}

