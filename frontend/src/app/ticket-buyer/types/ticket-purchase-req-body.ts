export interface TicketPurchaseReqBody {
  owner: {
    name: string,
    birthday: string,
    student: boolean,
    studentCard: boolean,
  },
  scheduleDay: string,
}
