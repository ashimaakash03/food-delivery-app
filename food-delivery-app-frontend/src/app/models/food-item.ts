export class FoodItem {
    id: number;
    name: string;
    category: string;
    imageUrl: string;
    price: number;
	quantity: number;
	ratings: number;

	constructor(id: number, name: string, category: string, imageUrl: string, price: number, quantity: number, ratings: number) {
        this.id = id;
        this.name = name;
        this.category = category;
        this.imageUrl = imageUrl;
        this.price = price;
		this.quantity = quantity;
		this.ratings = ratings;
    }
}
