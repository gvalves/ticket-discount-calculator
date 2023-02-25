export interface TicketPurchaseResBody {
  owner: {
    name: string,
    birthday: string,
    student: boolean,
    studentCard: boolean,
  },
  price: number,
}
