import {Injectable} from '@angular/core';
import {BehaviorSubject} from "rxjs";
import {FoodItem} from "../models/food-item";

@Injectable({
	providedIn: 'root'
})
export class CartService {

	public cartItemList: FoodItem[] = [];
	public foodList = new BehaviorSubject<any>([]);

	constructor() {
	}

	getFoods() {
		return this.foodList.asObservable();
	}

	setFood(food: any) {
		this.cartItemList.push(food);
		this.foodList.next(food);
	}

	addToCart(food: FoodItem) {
		this.cartItemList.push(food);
		this.foodList.next(this.cartItemList);
		this.getTotalPrice();
		alert(food.name + " was added");
	}

	getTotalPrice(): number {
		let totalPrice: number = 0;
		this.cartItemList.map((item: FoodItem) => {
			totalPrice += item.price;
		});
		return totalPrice;
	}

	removeCartItem(food: FoodItem) {
		this.cartItemList.map((item: FoodItem, index: number) => {
			if (food.id === item.id) {
				this.cartItemList.splice(index, 1);
			}
		});
		this.foodList.next(this.cartItemList);
	}

	clearCart() {
		this.cartItemList = [];
		this.foodList.next(this.cartItemList);
	}
}
