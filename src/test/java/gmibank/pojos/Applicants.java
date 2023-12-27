package gmibank.pojos;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import java.util.List;

@JsonIgnoreProperties(ignoreUnknown = true)
public class Applicants {


        public List<New_Applicant.NewApplicant> getApplicants() {
            return applicants;
        }

        public void setApplicants(List<New_Applicant.NewApplicant> applicants) {
            this.applicants = applicants;
        }

        private List<New_Applicant.NewApplicant> applicants;


    }

