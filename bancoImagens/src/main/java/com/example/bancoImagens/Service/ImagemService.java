package com.example.bancoImagens.Service;

import com.example.bancoImagens.Model.ImagemModel;
import com.example.bancoImagens.Repository.ImagemRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ImagemService {

    @Autowired
    private ImagemRepository repository;

    public ImagemModel adicionarImagens(ImagemModel imagemModel){
        return repository.save(imagemModel);
    }
    public List<ImagemModel> listarTodasImagens(){
        return repository.findAll();
    }

    public void deletarImagens(Long id){
         repository.deleteById(id);
    }

    public ImagemModel atualizarImagem(Long id, ImagemModel imagemModel) {
        Optional<ImagemModel> imagemExistenteOptional = repository.findById(id);

        if (imagemExistenteOptional.isPresent()) {
            ImagemModel imagemExistente = imagemExistenteOptional.get();

            imagemExistente.setNome(imagemModel.getNome());
            imagemExistente.setURL(imagemModel.getURL());

            return repository.save(imagemExistente);
        } else {
            throw new RuntimeException("Imagem não encontrada com o ID: " + id);
        }
    }


}
