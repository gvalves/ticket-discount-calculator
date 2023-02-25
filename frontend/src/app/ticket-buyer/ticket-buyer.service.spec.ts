import { TestBed } from '@angular/core/testing';

import { TicketBuyerService } from './ticket-buyer.service';

describe('TicketBuyerService', () => {
  let service: TicketBuyerService;

  beforeEach(() => {
    TestBed.configureTestingModule({});
    service = TestBed.inject(TicketBuyerService);
  });

  it('should be created', () => {
    expect(service).toBeTruthy();
  });
});
