import { BrowserModule } from '@angular/platform-browser';
import { NgModule } from '@angular/core';
import { FormsModule, ReactiveFormsModule } from '@angular/forms';
import { HttpClientModule, HTTP_INTERCEPTORS } from '@angular/common/http';

import { AppComponent } from './app.component';
import { HeaderComponent } from './header/header.component';
import { ShoppingListService } from "./shopping-list/shopping-list.service";
import { AppRoutingModule } from "./app-routing.module";
import { RecipeService } from './recipes/recipe.service';
import { DataStorageService } from "./shared/data-storage.service";
import { AuthComponent } from './auth/auth.component';
import { AuthService } from "./auth/auth.service";
import { AuthInterceptorService } from "./auth/auth-interceptor.service";
import { AuthGaurd } from './auth/auth.gaurd';
import { SharedModule } from './shared/shared.module';

@NgModule({
  declarations: [
    AppComponent,
    HeaderComponent,
    AuthComponent
  ],
  imports: [
    BrowserModule,
    FormsModule,
    ReactiveFormsModule,
    HttpClientModule,
    AppRoutingModule,
    SharedModule
  ],
  providers: [
    ShoppingListService, 
    RecipeService, 
    DataStorageService, 
    AuthService,
    AuthGaurd,
    {
      provide: HTTP_INTERCEPTORS,
      useClass: AuthInterceptorService,
      multi: true
    }
  ],
  bootstrap: [AppComponent]
})
export class AppModule { }
