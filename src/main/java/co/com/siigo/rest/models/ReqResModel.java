package co.com.siigo.rest.models;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({"name","job"})
public class ReqResModel {
    public String name;
    public String job;


    public static ReqResModel getReqRes(String name, String job) {
        return ReqResModel.builder()
                    .name(name)
                    .job(job)
            .build();
    }


}
