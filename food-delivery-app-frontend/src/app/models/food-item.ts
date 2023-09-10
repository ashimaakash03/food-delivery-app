export class FoodItem {
	id: number;
	name: string;
	category: string;
	imageUrl: string;
	price: number;

	constructor(id: number, name: string, category: string, imageUrl: string, price: number) {
		this.id = id;
		this.name = name;
		this.category = category;
		this.imageUrl = imageUrl;
		this.price = price;
	}
}
