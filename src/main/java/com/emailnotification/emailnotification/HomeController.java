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
        domain1Changes.add(new FieldChange("field1", null, "Added"));
        domain1Changes.add(new FieldChange("domain_registered", "no", "yes"));
        updatedData.put("domain1", domain1Changes);

        List<FieldChange> domain2Changes = new ArrayList<>();
        domain2Changes.add(new FieldChange("field3", "something", null));
        domain2Changes.add(new FieldChange("domain_registered", "yes", "no"));
        updatedData.put("domain2", domain2Changes);

        List<FieldChange> domain3Changes = new ArrayList<>();
        domain3Changes.add(new FieldChange("field3", "null", "newValue3"));
        domain3Changes.add(new FieldChange("value3", "null", "das"));
        updatedData.put("domain3", domain3Changes);

        List<FieldChange> domain4Changes = new ArrayList<>();
        domain4Changes.add(new FieldChange("field3", "value", null));
        domain4Changes.add(new FieldChange("valye", "yes", "yes"));
        updatedData.put("domain4", domain4Changes);

        List<FieldChange> domain5Changes = new ArrayList<>();
        domain5Changes.add(new FieldChange("field5", null, "Added"));
        domain5Changes.add(new FieldChange("value5", "no", "yes"));
        updatedData.put("domain5", domain5Changes);

        List<FieldChange> domain6Changes = new ArrayList<>();
        domain6Changes.add(new FieldChange("field3", "something", null));
        domain6Changes.add(new FieldChange("s", "yes", "yes"));
        updatedData.put("domain6", domain6Changes);

        List<FieldChange> domain7Changes = new ArrayList<>();
        domain7Changes.add(new FieldChange("field3", null, "old"));
        domain7Changes.add(new FieldChange("value3", "upd", "new"));
        updatedData.put("domain7", domain7Changes);

        List<FieldChange> domain8Changes = new ArrayList<>();
        domain8Changes.add(new FieldChange("field3", "value", null));
        domain8Changes.add(new FieldChange("domain_registered", "yes", "no"));
        updatedData.put("domain8", domain8Changes);

        model.addAttribute("updatedData", updatedData);
        model.addAttribute("update_date", LocalDate.now());

        return "index";
    }

    @GetMapping("/brand")
    public String brand(Model model) {
        List<Map<String, Object>> brandsData = new ArrayList<>();

        Map<String, Object> brandData1 =  new HashMap<>();
        brandData1.put("brand_keyword", "Google");
        brandData1.put("domainsDiscovered", 182);
        brandData1.put("domainsAdded", 7);
        brandData1.put("domainsUpdated", 38);
        brandData1.put("domainsDropped", 12);
        brandData1.put("typos_enabled", true);
        brandData1.put("typosDomainsDiscovered", 91);
        brandData1.put("typosDomainsAdded", 42);
        brandData1.put("typosDomainsUpdated", 2);
        brandData1.put("typosDomainsDropped", 102);
        brandsData.add(brandData1);


        Map<String, Object> brandData2 =  new HashMap<>();
        brandData2.put("brand_keyword", "WhoisFreaks");
        brandData2.put("domainsDiscovered", 94);
        brandData2.put("domainsAdded", 14);
        brandData2.put("domainsUpdated", 91);
        brandData2.put("domainsDropped", null);
        brandData2.put("typos_enabled", false);
        brandData2.put("typosDomainsDiscovered", 21);
        brandData2.put("typosDomainsAdded", 442);
        brandData2.put("typosDomainsUpdated", 1);
        brandData2.put("typosDomainsDropped", 2);
        brandsData.add(brandData2);

        Map<String, Object> brandData3 =  new HashMap<>();
        brandData3.put("brand_keyword", "Facebook");
        brandData3.put("domainsDiscovered", 0);
        brandData3.put("domainsUpdated", 32);
        brandData3.put("domainsDropped", null);
        brandData3.put("typos_enabled", true);
        brandData3.put("typosDomainsDiscovered", 91);
        brandData3.put("typosDomainsAdded", 42);
        brandData3.put("typosDomainsUpdated", 2);
        brandData3.put("typosDomainsDropped", 102);
        brandsData.add(brandData3);

        model.addAttribute("brands_data", brandsData);
        model.addAttribute("update_date", LocalDate.now());

        return "brand";
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
