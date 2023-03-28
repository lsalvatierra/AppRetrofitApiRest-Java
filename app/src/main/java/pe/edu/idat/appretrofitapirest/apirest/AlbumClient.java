package pe.edu.idat.appretrofitapirest.apirest;

import java.util.List;

import pe.edu.idat.appretrofitapirest.model.Album;
import retrofit2.Call;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class AlbumClient {

    private static final String BASE_URL = "https://jsonplaceholder.typicode.com/";
    private AlbumInterface albumInterface;
    private static AlbumClient INSTANCE;

    public AlbumClient(){
        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl(BASE_URL)
                .addConverterFactory(GsonConverterFactory.create())
                .build();
        albumInterface = retrofit.create(AlbumInterface.class);
    }
    public static AlbumClient getINSTANCE(){
        if(INSTANCE == null){
            INSTANCE = new AlbumClient();
        }
        return INSTANCE;
    }
    public Call<List<Album>> getAlbums(){
        return albumInterface.getAlbums();
    }

}
