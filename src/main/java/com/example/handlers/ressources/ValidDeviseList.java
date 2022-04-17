package com.example.handlers.ressources;

import java.util.List;

public class ValidDeviseList {
    private ValidDeviseList() {
    }

    static List<String> initialDeviseList = List.of(
            "AFG", "ZAF", "ALA", "ALB", "DZA", "DEU", "AND", "AGO", "AIA", "ATA", "ATG", "SAU", "ARG", "ARM",
            "ABW", "AUS", "AUT", "AZE", "BHS", "BHR", "BGD", "BRB", "BLR", "BEL", "BLZ", "BEN", "BMU", "BTN",
            "BOL", "BES", "BIH", "BWA", "BVT", "BRA", "BRN", "BGR", "BFA", "BDI", "CYM", "KHM", "CMR", "CAN",
            "CPV", "CAF", "CHL", "CHN", "CXR", "CYP", "CCK", "COL", "COM", "COG", "COD", "COK", "KOR", "PRK",
            "CRI", "CIV", "HRV", "CUB", "CUW", "DNK", "DJI", "DOM", "DMA", "EGY", "SLV", "ARE", "ECU", "ERI",
            "ESP", "USA", "ETH", "FLK", "FRO", "FJI", "FIN", "FRA", "GAB", "GMB", "GEO", "SGS", "GHA", "GIB",
            "GRC", "GRD", "GRL", "GLP", "GUM", "GTM", "GGY", "GIN", "GNB", "GNQ", "GUY", "GUF", "HTI", "HMD",
            "HND", "HKG", "HUN", "IMN", "UMI", "VGB", "VIR", "IND", "IDN", "IRN", "IRQ", "IRL", "ISL", "ISR",
            "ITA", "JAM", "JPN", "JEY", "JOR", "KAZ", "KEN", "KGZ", "KIR", "KWT", "LAO", "LSO", "LVA", "LBN",
            "LBR", "LBY", "LIE", "LTU", "LUX", "MAC", "MKD", "MDG", "MYS", "MWI", "MDV", "MLI", "MLT", "MNP",
            "MAR", "MHL", "MTQ", "MUS", "MRT", "MYT", "MEX", "FSM", "MDA", "MCO", "MNG", "MNE", "MSR", "MOZ",
            "MMR", "NAM", "NRU", "NPL", "NIC", "NER", "NGA", "NIU", "NFK", "NOR", "NCL", "NZL", "IOT", "OMN",
            "UGA", "UZB", "PAK", "PLW", "PSE", "PAN", "PNG", "PRY", "NLD", "PER", "PHL", "PCN", "POL", "PYF",
            "PRI", "PRT", "QAT", "REU", "ROU", "GBR", "RUS", "RWA", "ESH", "BLM", "KNA", "SMR", "MAF", "SXM",
            "SPM", "VAT", "VCT", "SHN", "LCA", "SLB", "WSM", "ASM", "STP", "SEN", "SRB", "SYC", "SLE", "SGP",
            "SVK", "SVN", "SOM", "SDN", "SSD", "LKA", "SWE", "CHE", "SUR", "SJM", "SWZ", "SYR", "TJK", "TWN",
            "TZA", "TCD", "CZE", "ATF", "THA", "TLS", "TGO", "TKL", "TON", "TTO", "TUN", "TKM", "TCA", "TUR",
            "TUV", "UKR", "URY", "VUT", "VEN", "VNM", "WLF", "YEM", "ZMB", "ZWE"
    );

    public static List<String> fetchDeviseList(){
        return initialDeviseList;
    }
}


