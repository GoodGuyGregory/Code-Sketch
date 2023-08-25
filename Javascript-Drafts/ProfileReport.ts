export class ProfileReport {
    public scriptId: string;
    public reportSchedule: string;
    public reportName: string;

    constructor(scriptId: string, reportSchedule: string, reportName: string) {

        this.scriptId = scriptId;
        this.reportSchedule = reportSchedule;
        this.reportName = reportName;
    }

}