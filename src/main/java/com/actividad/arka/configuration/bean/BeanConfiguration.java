package com.actividad.arka.configuration.bean;

import com.actividad.arka.adapters.driven.adapter.CartAdapter;
import com.actividad.arka.adapters.driven.adapter.CategoryAdapter;
import com.actividad.arka.adapters.driven.adapter.OrderAdapter;
import com.actividad.arka.adapters.driven.adapter.ProductAdapter;
import com.actividad.arka.adapters.driven.mapper.ICartEntityMapper;
import com.actividad.arka.adapters.driven.mapper.ICategoryEntityMapper;
import com.actividad.arka.adapters.driven.mapper.IOrderEntityMapper;
import com.actividad.arka.adapters.driven.mapper.IProductEntityMapper;
import com.actividad.arka.adapters.driven.repository.ICartRepository;
import com.actividad.arka.adapters.driven.repository.ICategoryRepository;
import com.actividad.arka.adapters.driven.repository.IOrderRepository;
import com.actividad.arka.adapters.driven.repository.IProductRepository;
import com.actividad.arka.domain.api.ICartServicePort;
import com.actividad.arka.domain.api.IOrderServicePort;
import com.actividad.arka.domain.api.IProductServicePort;
import com.actividad.arka.domain.spi.ICartPersistencePort;
import com.actividad.arka.domain.spi.ICategoryPersistencePort;
import com.actividad.arka.domain.spi.IOrderPersistencePort;
import com.actividad.arka.domain.spi.IProductPersistencePort;
import com.actividad.arka.domain.usecase.CartUseCase;
import com.actividad.arka.domain.usecase.OrderUseCase;
import com.actividad.arka.domain.usecase.ProductUseCase;
import lombok.RequiredArgsConstructor;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@RequiredArgsConstructor
@Configuration
public class BeanConfiguration {


    @Bean
    public ICategoryPersistencePort categoryPersistencePort(ICategoryRepository categoryRepository, ICategoryEntityMapper categoryEntityMapper) {
        return new CategoryAdapter(categoryRepository, categoryEntityMapper);
    }


    @Bean
    public IProductPersistencePort productPersistencePort(IProductRepository productRepository, IProductEntityMapper productEntityMapper) {
        return new ProductAdapter(productRepository, productEntityMapper);
    }

    @Bean
    public IProductServicePort productServicePort(IProductPersistencePort productPersistencePort, ICategoryPersistencePort categoryPersistencePort) {
        return new ProductUseCase( productPersistencePort,  categoryPersistencePort);
    }
    @Bean
    public IOrderServicePort  orderServicePort(IProductPersistencePort productPersistencePort, IOrderPersistencePort orderPersistencePort) {
        return new OrderUseCase(productPersistencePort,  orderPersistencePort);
    }
    @Bean
    public IOrderPersistencePort orderPersistencePort(IOrderRepository orderRepository, IOrderEntityMapper orderEntityMapper) {
        return new OrderAdapter(orderRepository, orderEntityMapper);
    }
    @Bean
    public ICartPersistencePort cartPersistencePort(ICartRepository cartRepository, ICartEntityMapper cartEntityMapper) {
        return new CartAdapter(cartRepository, cartEntityMapper);
    }
    @Bean
    public ICartServicePort cartServicePort(ICartPersistencePort cartPersistencePort) {
        return new CartUseCase(cartPersistencePort);
    }
}