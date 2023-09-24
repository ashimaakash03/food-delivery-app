import {Component, OnInit} from '@angular/core';
import {CartService} from "../../services/cart.service";

@Component({
  selector: 'app-header',
  templateUrl: './header.component.html',
  styleUrls: ['./header.component.css']
})
export class HeaderComponent implements OnInit {

	public itemsInCart: number = 0;

	constructor(private cartService: CartService) {
	}

	ngOnInit(): void {
		this.cartService.getFoods().subscribe((res) => {
			this.itemsInCart = res.length;
		})
	}
}
