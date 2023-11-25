package tda.darkarmy.sneakerhead.service;


import org.modelmapper.internal.bytebuddy.pool.TypePool;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import tda.darkarmy.sneakerhead.dto.CartItemDto;
import tda.darkarmy.sneakerhead.exception.ResourceNotFoundException;
import tda.darkarmy.sneakerhead.model.Cart;
import tda.darkarmy.sneakerhead.model.CartItem;
import tda.darkarmy.sneakerhead.model.Sneakers;
import tda.darkarmy.sneakerhead.model.User;
import tda.darkarmy.sneakerhead.repository.CartItemRepository;
import tda.darkarmy.sneakerhead.repository.CartRepository;
import tda.darkarmy.sneakerhead.repository.SneakerRepository;

import java.util.Arrays;

@Service
public class CartService {
    @Autowired
    private CartRepository cartRepository;

    @Autowired
    private CartItemRepository cartItemRepository;

    @Autowired
    private UserService userService;

    @Autowired
    private SneakerRepository sneakerRepository;

    public Cart getMyCart(){
        User user = userService.getLoggedInUser();
        return cartRepository.findByUser(user);
    }

    public Cart addToCart(CartItemDto cartItemDto){
        User user = userService.getLoggedInUser();
        Sneakers sneakers = sneakerRepository.findById(cartItemDto.getSneakerId()).orElseThrow(()-> new TypePool.Resolution.NoSuchTypeException("Product not found"));
        Cart cart = cartRepository.findByUser(user);
        if(cart==null) {
            cart = cartRepository.save(new Cart(Arrays.asList(), user, 0));
        }
        CartItem cartItem = cartItemRepository.save(new CartItem(sneakers,cart, cartItemDto.getQuantity()));

        cart.setTotalPrice(cart.getTotalPrice()+ sneakers.getPrice()*cartItem.getQuantity());
        cart = cartRepository.save(cart);
        return cart;
    }

    public Cart deleteFromCart(Long cartItemId){
        User user = userService.getLoggedInUser();
        CartItem cartItem = cartItemRepository.findById(cartItemId).orElseThrow(()-> new ResourceNotFoundException("Cart Item not found"));
        Cart cart = cartRepository.findByUser(user);
        cart.setTotalPrice(cart.getTotalPrice()-cartItem.getProduct().getPrice()+cartItem.getQuantity());
        cartItemRepository.deleteById(cartItemId);
        return cartRepository.save(cart);
    }

}
