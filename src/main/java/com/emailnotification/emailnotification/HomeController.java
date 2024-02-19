package com.emailnotification.emailnotification;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Controller
public class HomeController {

    @GetMapping("/")
    public String index(Model model) {
        Map<String, List<FieldChange>> updatedData = new HashMap<>();

        List<FieldChange> domain1Changes = new ArrayList<>();
        domain1Changes.add(new FieldChange("field1", "oldValue1oldValue1oldValue1oldValue1oldValue1oldValue1oldValue1oldValue1old", null));
        domain1Changes.add(new FieldChange("domain_registered", "no", "yes"));
        updatedData.put("domain1", domain1Changes);

        List<FieldChange> domain2Changes = new ArrayList<>();
        domain2Changes.add(new FieldChange("field3", null, "newValue3"));
        domain2Changes.add(new FieldChange("domain_registered", "yes", "no"));
        updatedData.put("domain2", domain2Changes);

        List<FieldChange> domain3Changes = new ArrayList<>();
        domain3Changes.add(new FieldChange("field3", null, "newValue3"));
        domain3Changes.add(new FieldChange("value3", "yeae", "das"));
        updatedData.put("domain3", domain3Changes);

        model.addAttribute("updatedData", updatedData);
        model.addAttribute("update_date", LocalDate.now());

        return "index";
    }

    public static class FieldChange {
        private String field;
        private String old_value;
        private String new_value;

        public FieldChange(String field, String old_value, String new_value) {
            this.field = field;
            this.old_value = old_value;
            this.new_value = new_value;
        }

        public String getField() {
            return field;
        }

        public String getOld_value() {
            return old_value;
        }

        public String getNew_value() {
            return new_value;
        }
    }
}
