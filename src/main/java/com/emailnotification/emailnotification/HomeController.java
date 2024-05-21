package com.emailnotification.emailnotification;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import java.time.LocalDate;
import java.util.*;
import java.util.stream.Collectors;

@Controller
public class HomeController {

    @GetMapping("/")
    public String index(Model model) {
        Map<String, List<FieldChange>> updatedData = new HashMap<>();

        List<FieldChange> domain1Changes = new ArrayList<>();
        domain1Changes.add(new FieldChange("field1", null, "Added"));
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

        Map<String, List<FieldChange>> filteredData = updatedData.entrySet().stream()
                .filter(entry -> entry.getValue().stream()
                        .anyMatch(change -> "domain_registered".equals(change.getField()) && "yes".equals(change.getOld_value()) && "no".equals(change.getNew_value())))
                .collect(Collectors.toMap(Map.Entry::getKey, Map.Entry::getValue));

        model.addAttribute("filteredData", filteredData);

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
        brandData2.put("typos_enabled", true);
        brandData2.put("typosDomainsDiscovered", 21);
        brandData2.put("typosDomainsAdded", 442);
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
        model.addAttribute("username", "user123");

        return "brand";
    }

    @GetMapping("/support")
    public String support(Model model) {

        Map<String, Object> supportData =  new HashMap<>();
        supportData.put("api_key", "42354545446421m9b6c0010d48bce892");
        supportData.put("error_code", "413");
        supportData.put("request_type", "Live Dns Lookup");

        model.addAttribute("username", "XYZ");
        model.addAttribute("support_data", supportData);

        return "support";
    }

    @GetMapping("/failure/status")
    public String failedStatus(Model model) {

        Map<String, List<Map.Entry<String, Object>>> failedStatusData = new HashMap<>();

        failedStatusData.putIfAbsent("Live Whois Lookup", new ArrayList<>());
        failedStatusData.get("Live Whois Lookup").add(new AbstractMap.SimpleEntry<>("429", 11));
        failedStatusData.get("Live Whois Lookup").add(new AbstractMap.SimpleEntry<>("403", 23));

        failedStatusData.putIfAbsent("Live Dns Lookup", new ArrayList<>());
        failedStatusData.get("Live Dns Lookup").add(new AbstractMap.SimpleEntry<>("403", 9));
        failedStatusData.get("Live Dns Lookup").add(new AbstractMap.SimpleEntry<>("429", 31));

        failedStatusData.putIfAbsent("SSL Live Lookup", new ArrayList<>());
        failedStatusData.get("SSL Live Lookup").add(new AbstractMap.SimpleEntry<>("429", 52));

        failedStatusData.putIfAbsent("Historical Dns Lookup", new ArrayList<>());
        failedStatusData.get("Historical Dns Lookup").add(new AbstractMap.SimpleEntry<>("403", 21));
        failedStatusData.get("Historical Dns Lookup").add(new AbstractMap.SimpleEntry<>("429", 19));

        model.addAttribute("username", "XYZ");
        model.addAttribute("date", LocalDate.now());
        model.addAttribute("failed_status_data", failedStatusData);

        return "failureStatus";
    }

    public static class FieldChange {
        private final String field;
        private final String old_value;
        private final String new_value;

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
