import { NgModule } from '@angular/core';
import { BrowserModule } from '@angular/platform-browser';

import { AppRoutingModule } from './app-routing.module';
import { AppComponent } from './app.component';
import { TicketBuyerModule } from './ticket-buyer/ticket-buyer.module';

@NgModule({
  declarations: [
    AppComponent
  ],
  imports: [
    BrowserModule,
    AppRoutingModule,
    TicketBuyerModule,
  ],
  providers: [],
  bootstrap: [AppComponent]
})
export class AppModule { }
