package kz.greetgo.cash_management_service.in_service.acs.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import java.util.List;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@JsonIgnoreProperties(ignoreUnknown = true)
public class SessionResponse {

  @JsonProperty("sessionId")
  public String sessionId;

  @JsonProperty("token")
  public String token;

  @JsonProperty("appCode")
  public String appCode;

  @JsonProperty("personGuid")
  public String personGuid;

  @JsonProperty("role")
  public String role;

  @JsonProperty("roleName")
  public String roleName;

  @JsonProperty("displayName")
  public String displayName;

  @JsonProperty("username")
  public String username;

  @JsonProperty("errorMessage")
  public String errorMessage;

  @JsonProperty("status")
  public Integer status;

  @JsonProperty("error")
  public Boolean error;

  @JsonProperty("appKey")
  public String appKey;

  @JsonProperty("functions")
  public List<AcsFunction> functions;

}

