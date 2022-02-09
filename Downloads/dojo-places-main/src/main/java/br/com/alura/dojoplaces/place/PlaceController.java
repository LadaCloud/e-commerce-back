package br.com.alura.dojoplaces.place;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class PlaceController {

    private final PlaceRepository placeRepository;

    public PlaceController(PlaceRepository placeRepository) {
        this.placeRepository = placeRepository;
    }

    @GetMapping("/create/local/form")
    public String createLocalForm(PlaceNewForm placeNewForm) {
        return "/place/newForm";
    }

    @PostMapping("/create/local")
    public String create(@Valid PlaceNewForm placeForm, BindingResult bindingResult, Model model) {
        if(bindingResult.hasErrors()) {
            return createLocalForm(placeForm,model);
        }

        Place place = placeForm.toModel();
        placeRepository.save(place);

        return "/place/newForm";
    }

    @GetMapping("update/local/form")
    public String update(PlaceUpdateForm placeUpdateForm) {
        return "place/updateForm";
    }

}
