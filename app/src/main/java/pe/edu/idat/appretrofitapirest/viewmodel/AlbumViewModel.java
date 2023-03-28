package pe.edu.idat.appretrofitapirest.viewmodel;

import android.app.Application;
import android.util.Log;

import androidx.annotation.NonNull;
import androidx.lifecycle.AndroidViewModel;
import androidx.lifecycle.MutableLiveData;

import java.util.List;

import pe.edu.idat.appretrofitapirest.apirest.AlbumClient;
import pe.edu.idat.appretrofitapirest.model.Album;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class AlbumViewModel extends AndroidViewModel {
    public MutableLiveData<List<Album>> listMutableLiveData =
            new MutableLiveData<>();
    public MutableLiveData<String> albums = new MutableLiveData<>();

    public AlbumViewModel(@NonNull Application application) {
        super(application);
    }

    public void getAlbums(){
        AlbumClient.getINSTANCE().getAlbums().enqueue(new Callback<List<Album>>() {
            @Override
            public void onResponse(Call<List<Album>> call, Response<List<Album>> response) {
                Log.i("DATAREST", response.body().toString());
                listMutableLiveData.setValue(response.body());
            }

            @Override
            public void onFailure(Call<List<Album>> call, Throwable t) {
                albums.setValue(t.getMessage());
            }
        });
    }

}
