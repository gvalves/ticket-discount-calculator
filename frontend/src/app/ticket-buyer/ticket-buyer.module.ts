import { NgModule } from '@angular/core';
import { CommonModule } from '@angular/common';
import { TicketBuyerComponent } from './ticket-buyer.component';
import { FormComponent } from './form/form.component';
import { FormsModule } from '@angular/forms';
import { TicketBuyerService } from './ticket-buyer.service';



@NgModule({
  declarations: [
    TicketBuyerComponent,
    FormComponent
  ],
  providers: [TicketBuyerService],
  imports: [
    CommonModule, FormsModule
  ],
  exports: [
    TicketBuyerComponent
  ]
})
export class TicketBuyerModule { }
