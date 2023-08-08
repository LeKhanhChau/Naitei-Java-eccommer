package app.service.Impl;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Service;

import app.model.CartItem;
import app.service.ShoppingCartService;

@Service
public class ShoppingCartServiceImpl implements ShoppingCartService {
	private List<CartItem> cartItems = new ArrayList<>();

	@Override
	public void addItem(CartItem item) {
		// Kiểm tra xem sản phẩm đã tồn tại trong giỏ hàng chưa
		for (CartItem cartItem : cartItems) {
			if (cartItem.getProduct().getId().equals(item.getProduct().getId())) {
				cartItem.setQuantity(cartItem.getQuantity() + item.getQuantity());
				return;
			}
		}
		// Nếu chưa tồn tại, thêm sản phẩm vào giỏ hàng
		cartItems.add(item);
	}

	@Override
	public void removeItem(CartItem item) {
		// TODO Auto-generated method stub

	}

	@Override
	public List<CartItem> getCartItems() {
		return cartItems;
	}

}
