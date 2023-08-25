import { CustomerReport } from "./CustomerReport";
import { ProfileReport } from "./ProfileReport";

let CustomerReports : ProfileReport = [
    {
        "scriptId": 161,
        "reportSchedule": "Always Fails",
        "reportName": "* * * * *"
    },
    {
        "scriptId": 41,
        "reportSchedule": "Percentage stepOne",
        "reportName": null
    },
    {
        "scriptId": 61,
        "reportSchedule": "Scrollable stepOne",
        "reportName": null
    },
    {
        "scriptId": 201,
        "reportSchedule": "Currency Format stepOne",
        "reportName": null
    },
    {
        "scriptId": 281,
        "reportSchedule": "BAE_DAILY_INVENTORY",
        "reportName": null
    },
    {
        "scriptId": 421,
        "reportSchedule": "POURS Forecast",
        "reportName": "13 9 * * *"
    },
    {
        "scriptId": 121,
        "reportSchedule": "ZKE1",
        "reportName": null
    },
    {
        "scriptId": 141,
        "reportSchedule": "Data transfer stepOne",
        "reportName": null
    },
    {
        "scriptId": 461,
        "reportSchedule": "Firstronic stepOne FTPS",
        "reportName": null
    },
    {
        "scriptId": 2182,
        "reportSchedule": "Schweitzer Parts List with QOH & Backorder Qty",
        "reportName": null
    },
    {
        "scriptId": 341,
        "reportSchedule": "Succeeds in first 10 mins",
        "reportName": "*/10 * * * *"
    },
    {
        "scriptId": 62,
        "reportSchedule": "Delimited stepOne",
        "reportName": null
    },
    {
        "scriptId": 23,
        "reportSchedule": "Initialize stepOne - :yyyyMMdd:",
        "reportName": null
    },
    {
        "scriptId": 101,
        "reportSchedule": "Custom Excel stepOne",
        "reportName": null
    },
    {
        "scriptId": 401,
        "reportSchedule": "Schweitzer LT Report",
        "reportName": null
    },
    {
        "scriptId": 422,
        "reportSchedule": "Forecast Cleanup",
        "reportName": "13 9 * * *"
    },
    {
        "scriptId": 181,
        "reportSchedule": "Output stepOne",
        "reportName": null
    },
    {
        "scriptId": 241,
        "reportSchedule": "Query Runner Scripts",
        "reportName": "*/9 * * * *"
    },
    {
        "scriptId": 261,
        "reportSchedule": "Succeeds on the first fiscal Monday",
        "reportName": "0 0 * * *"
    },
    {
        "scriptId": 423,
        "reportSchedule": "Forecast Demand Summary",
        "reportName": "13 9 * * *"
    }
];


let customerQRreports: CustomerReport[] = [
    {
        "reportSchedule": "at 09:13",
        "reportName": "POURS Forecast",
        "reportDescription": "This script simulates the POURS Forecast script on production (#6). It executes nothing but runs for ~150s.",
        "reportRecipients": [
            "greg.witt@avnet.com"
        ],
        "customerId": "0040011398",
        "salesOrgCode": "U001",
        "scriptId": 421,
        "serviceModel": "BIPP"
    }
]

if (customerQRreports.length > 0) {
    this.filteredProfileReports = this.filteredProfileReports.filter((report) => {
        this.customerQrReports.forEach(customerQr => {
            if (report.scriptId == customerQr.scriptId) {
                return 0;
            } else {
                return 0;
            }
        })
    });
}