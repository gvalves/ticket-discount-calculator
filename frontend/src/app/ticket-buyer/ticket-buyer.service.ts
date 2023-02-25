import { Injectable } from '@angular/core';
import { TicketPurchaseReqBody } from './types/ticket-purchase-req-body';
import { TicketPurchaseResBody } from './types/ticket-purchase-res-body';

@Injectable()
export class TicketBuyerService {

  constructor() { }

  async sendTicketPurchaseRequisition(body: TicketPurchaseReqBody): Promise<TicketPurchaseResBody> {
    const res = await fetch('http://localhost:8080/ticket/buy', {
      method: 'POST',
      headers: {
        'Accept': 'application/json',
        'Content-Type': 'application/json'
      },
      body: JSON.stringify(body)
    });
    return await res.json() as TicketPurchaseResBody;
  }
}
