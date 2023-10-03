import {NgModule} from '@angular/core';
import {RouterModule, Routes} from "@angular/router";
import {HomepageComponent} from "./components/homepage/homepage.component";
import {RegisterComponent} from "./components/register/register.component";
import {NotFoundComponent} from "./components/not-found/not-found.component";
import {LoginComponent} from "./components/login/login.component";
import {CartPageComponent} from "./components/cart-page/cart-page.component";
import {MenupageComponent} from "./components/menupage/menupage.component";
import {CheckoutComponent} from "./components/checkout/checkout.component";
import {authGuard} from "./guards/auth.guard";

const routes: Routes = [{path: "", redirectTo: "\login", pathMatch: "full"}, {
    path: "home",
    component: HomepageComponent,
    canActivate: [authGuard]
}, {path: "register", component: RegisterComponent}, {path: "login", component: LoginComponent}, {
    path: "menu",
    component: MenupageComponent,
    canActivate: [authGuard]
}, {path: "cart", component: CartPageComponent, canActivate: [authGuard]}, {
    path: "checkout",
    component: CheckoutComponent,
    canActivate: [authGuard]
}, {path: "**", component: NotFoundComponent}]

@NgModule({
    declarations: [], imports: [RouterModule.forRoot(routes)], exports: [RouterModule]
})
export class AppRoutingModule {
}
