import {NgModule} from '@angular/core';
import {RouterModule, Routes} from "@angular/router";
import {HomepageComponent} from "./components/homepage/homepage.component";
import {RegisterComponent} from "./components/register/register.component";
import {NotFoundComponent} from "./components/not-found/not-found.component";

const routes: Routes = [
	{path: "", redirectTo: "\home", pathMatch: "full"},
	{path: "home", component: HomepageComponent},
	{path: "register", component: RegisterComponent},
	{path: "**", component: NotFoundComponent}
]
@NgModule({
  declarations: [],
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule { }
