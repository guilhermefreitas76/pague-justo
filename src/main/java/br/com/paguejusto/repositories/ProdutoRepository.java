package br.com.paguejusto.repositories;

import java.util.List;
import java.util.Optional;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import br.com.paguejusto.domain.Categoria;
import br.com.paguejusto.domain.Produto;

@Repository
@Transactional(readOnly = true)
public interface ProdutoRepository extends CrudRepository<Produto, Long> {

	public abstract Optional<Produto> findById(Long id);

	//A Query tem prioridade sobre o meu metodo, porém fazem a mesma coisa...Ver doc spring data.
	@Transactional(readOnly=true)
	@Query("SELECT DISTINCT obj FROM Produto obj INNER JOIN obj.categorias cat WHERE obj.nome LIKE %:nome% AND cat IN :categorias")
	public abstract Page<Produto> findDistinctByNomeContainingAndCategoriasIn(@Param("nome") String nome,
			@Param("categorias") List<Categoria> categorias, Pageable pageRequest);

}
