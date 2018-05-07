package ru.stqa.pft.rest;

import com.google.gson.JsonElement;
import com.google.gson.JsonParser;
import com.jayway.restassured.RestAssured;
import org.testng.SkipException;

public class TestBase {

  private boolean isIssueOpen(int issueId) {
    String json = RestAssured.get(String.format("http://demo.bugify.com/api/issues/json", issueId)).asString();
    JsonElement parsed = new JsonParser().parse(json);
    JsonElement issues = parsed.getAsJsonObject().get("issues");
    int state = issues.getAsJsonArray().iterator().next().getAsJsonObject().get("state").getAsInt();
    if (state == 3) {
      return false;
    } else {
      return true;
    }
  }

  public void skipIfNotFixed(int issueId) {
    if (isIssueOpen(issueId)) {
      throw new SkipException("Ignored because of issue " + issueId);
    }
  }
}
