import { formatCurrency, formatDate } from '@angular/common';
import { Component, OnInit } from '@angular/core';
import { TicketBuyerService } from '../ticket-buyer.service';
import { FormFieldsValue } from './types/form-fields-value';

@Component({
  selector: 'ticket-buyer-form',
  templateUrl: './form.component.html',
  styleUrls: ['./form.component.css']
})
export class FormComponent implements OnInit {

  constructor(private ticketBuyerService: TicketBuyerService) {  }

  ngOnInit(): void {
    this.formFieldsValue.scheduleDay = formatDate(new Date(), 'yyyy-MM-dd', 'en');
  }

  formFieldsValue: FormFieldsValue = {
    owner: {
      name: '',
      birthday: '',
      student: false,
      studentCard: false
    },
    scheduleDay: ''
  };

  async handleSubmit() {
    console.log(this.formFieldsValue);
    const res = await this.ticketBuyerService.sendTicketPurchaseRequisition(this.formFieldsValue);
    console.log(res);
    alert(`O preço do ingresso é ${formatCurrency(res.price, 'en', 'R$')}`);
  }
}
