package htin.linnzaw.mvvm.service.repository;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;

import java.util.List;

import htin.linnzaw.mvvm.service.model.Project;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class ProjectRepository
{
    private GithubService githubservice;

    public LiveData<List<Project>> getProjectList(String userId)
    {
        final MutableLiveData<List<Project>> data = new MutableLiveData<>();

        githubservice.getProjectList(userId).enqueue(new Callback<List<Project>>()
        {
            @Override
            public void onResponse(Call<List<Project>> call, Response<List<Project>> response)
            {
                data.setValue(response.body());
            }

            @Override
            public void onFailure(Call<List<Project>> call, Throwable throwable)
            {

            }
        });

        return data;
    }
}
