import {Component, OnInit} from '@angular/core';
import {FoodItem} from "../../models/food-item";
import {CartService} from "../../services/cart.service";

@Component({
	selector: 'app-cart-page',
	templateUrl: './cart-page.component.html',
	styleUrls: ['./cart-page.component.css']
})
export class CartPageComponent implements OnInit {
	public foods: FoodItem[] = [];
	public grandTotal: number = 0;

	constructor(private cartService: CartService) {
	}

	ngOnInit(): void {
		this.cartService.getFoods().subscribe((res) => {
			this.foods = res;
			this.grandTotal = this.cartService.getTotalPrice();
		})
	}

	removeItem(food: FoodItem) {
		this.cartService.removeCartItem(food);
	}

	clearCart() {
		this.cartService.clearCart();
	}

	decreaseQuantity(item: FoodItem): number {
		if (item.quantity <= 1) {
			alert("Quantity Cannot be decreased");
		} else {
			item.quantity--;
		}
		return item.quantity;
	}

	increaseQuantity(item: FoodItem): number {
		item.quantity++;
		return item.quantity;
	}
}
