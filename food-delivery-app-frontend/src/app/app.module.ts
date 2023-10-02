import {NgModule} from '@angular/core';
import {BrowserModule} from '@angular/platform-browser';
import {AppComponent} from './app.component';
import {HeaderComponent} from './components/header/header.component';
import {SearchComponent} from './components/search/search.component';
import {RegisterComponent} from './components/register/register.component';
import {AppRoutingModule} from './app-routing.module';
import {BrowserAnimationsModule} from '@angular/platform-browser/animations';
import {LoginComponent} from './components/login/login.component';
import {MatInputModule} from "@angular/material/input";
import {FormsModule, ReactiveFormsModule} from "@angular/forms";
import {MatButtonModule} from "@angular/material/button";
import {MatSnackBarModule} from "@angular/material/snack-bar";
import {HttpClientModule} from "@angular/common/http";
import {MatListModule} from "@angular/material/list";
import {MatIconModule} from "@angular/material/icon";
import {MatToolbarModule} from "@angular/material/toolbar";
import {CartPageComponent} from './components/cart-page/cart-page.component';
import {HomepageComponent} from "./components/homepage/homepage.component";
import {FooterComponent} from './components/footer/footer.component';
import {MenupageComponent} from './components/menupage/menupage.component';
import {MatSelectModule} from "@angular/material/select";
import {MatCardModule} from "@angular/material/card";
import {CheckoutComponent} from "./components/checkout/checkout.component";

@NgModule({
	declarations: [AppComponent, HeaderComponent, SearchComponent, RegisterComponent, LoginComponent, CartPageComponent, HomepageComponent, FooterComponent, MenupageComponent, CheckoutComponent],
	imports: [BrowserModule, AppRoutingModule, BrowserAnimationsModule, MatInputModule, ReactiveFormsModule, MatButtonModule, FormsModule, MatSnackBarModule, HttpClientModule, MatListModule, MatIconModule, MatToolbarModule, MatSelectModule, MatCardModule],
	providers: [],
	bootstrap: [AppComponent]
})
export class AppModule {
}
