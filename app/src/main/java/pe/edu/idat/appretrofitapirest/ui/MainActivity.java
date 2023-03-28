package pe.edu.idat.appretrofitapirest.ui;

import androidx.appcompat.app.AppCompatActivity;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProvider;
import androidx.recyclerview.widget.LinearLayoutManager;

import android.os.Bundle;

import java.util.List;

import pe.edu.idat.appretrofitapirest.R;
import pe.edu.idat.appretrofitapirest.databinding.ActivityMainBinding;
import pe.edu.idat.appretrofitapirest.model.Album;
import pe.edu.idat.appretrofitapirest.ui.adapter.AlbumAdapter;
import pe.edu.idat.appretrofitapirest.viewmodel.AlbumViewModel;

public class MainActivity extends AppCompatActivity {

    private ActivityMainBinding binding;
    private AlbumViewModel albumViewModel;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityMainBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());
        albumViewModel = new ViewModelProvider(this).get(AlbumViewModel.class);
        albumViewModel.getAlbums();
        AlbumAdapter adapter = new AlbumAdapter();
        binding.rvalbums.setLayoutManager(new LinearLayoutManager(this));
        binding.rvalbums.setAdapter(adapter);
        albumViewModel.listMutableLiveData.observe(this,
                new Observer<List<Album>>() {
                    @Override
                    public void onChanged(List<Album> albums) {
                        adapter.setAlbumList(albums);
                    }
                });
    }
}