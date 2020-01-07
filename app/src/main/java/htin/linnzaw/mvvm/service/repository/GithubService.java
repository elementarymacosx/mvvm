package htin.linnzaw.mvvm.service.repository;

import java.util.List;

import htin.linnzaw.mvvm.service.model.Project;
import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Path;

public interface GithubService
{
    String HTTPS_Api_Github_Url = "https://api.github.com/";

    @GET("users/{user}/repos")
    Call<List<Project>> getProjectList(@Path("user") String user);

    @GET("/repos/{user}/{reponame}")
    Call<Project> getProjectDetails(@Path("user") String user, @Path("reponame") String projectName);
}
