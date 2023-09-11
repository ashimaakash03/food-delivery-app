export class FoodItem {
    id: number;
    name: string;
    category: string;
    imageUrl: string;
    price: number;
    ratings: number;
    isFavorite: boolean;

    constructor(id: number, name: string, category: string, imageUrl: string, price: number, ratings: number, isFavorite: boolean) {
        this.id = id;
        this.name = name;
        this.category = category;
        this.imageUrl = imageUrl;
        this.price = price;
        this.ratings = ratings;
        this.isFavorite = isFavorite;
    }
}
