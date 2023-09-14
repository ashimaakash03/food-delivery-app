import {NgModule} from '@angular/core';
import {RouterModule, Routes} from "@angular/router";
import {HomepageComponent} from "./components/homepage/homepage.component";
import {RegisterComponent} from "./components/register/register.component";
import {NotFoundComponent} from "./components/not-found/not-found.component";
import {LoginComponent} from "./components/login/login.component";
import {CartPageComponent} from "./components/cart-page/cart-page.component";
import {ItemDetailsComponent} from "./components/item-details/item-details.component";
import {MenupageComponent} from "./components/menupage/menupage.component";

const routes: Routes = [
	{path: "", redirectTo: "\home", pathMatch: "full"},
	{path: "home", component: HomepageComponent},
	{path: "register", component: RegisterComponent},
	{path: "login", component: LoginComponent},
	{path: "menu", component: MenupageComponent},
	{path: "cart", component: CartPageComponent},
	{path: "details", component: ItemDetailsComponent},
	{path: "**", component: NotFoundComponent}
]
@NgModule({
  declarations: [],
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule { }
