package net.pcheck.service;

import java.util.List;

import javax.annotation.Resource;

import net.paxcel.uibean.ProductUIBean;
import net.pcheck.mapper.ProductMapper;
import net.pcheck.modal.Product;
import net.pcheck.repository.ProductRepository;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class ProductServiceImpl implements ProductService{
	@Resource
    private ProductRepository productRepository;
	ProductMapper mapper = new ProductMapper();
	
	@Override
    @Transactional
	public void createProducts(List<Product> products) {
		productRepository.save(products);
	}
	public List<ProductUIBean> findAll() {
		return mapper.toUIBean(productRepository.findAll());
	}
	@Override
	public Page<ProductUIBean> findAll(Pageable pageable) {		
		return mapper.toUIBean(productRepository.findAll(pageable), pageable);
	}

}
