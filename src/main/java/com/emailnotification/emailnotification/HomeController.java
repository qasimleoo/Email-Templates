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
        domain1Changes.add(new FieldChange("field1", "oldValue1oldValue1oldValue1oldValue1oldValue1oldValue1oldValue1oldValue1oldValue1", "newValue1newValue1newValue1newValue1newValue1newValue1newValue1newValue1newValue1"));
        domain1Changes.add(new FieldChange("field2", "oldValue2", "newValue2"));
        updatedData.put("domain1", domain1Changes);

        List<FieldChange> domain2Changes = new ArrayList<>();
        domain2Changes.add(new FieldChange("field3", "oldValue3", "newValue3"));
        domain2Changes.add(new FieldChange("field4", "oldValue4", "newValue4"));
        updatedData.put("domain2", domain2Changes);

        model.addAttribute("updatedData", updatedData);
        model.addAttribute("update_date", LocalDate.now());

        return "index";
    }

    public static class FieldChange {
        private String field_name;
        private String old_value;
        private String new_value;

        public FieldChange(String field_name, String old_value, String new_value) {
            this.field_name = field_name;
            this.old_value = old_value;
            this.new_value = new_value;
        }

        public String getField_name() {
            return field_name;
        }

        public String getOld_value() {
            return old_value;
        }

        public String getNew_value() {
            return new_value;
        }
    }
}
