export class Pet {
  constructor(
    public id: number | null,
    public name: string | null,
    public type: string | null,
    public furColor: string | null,
    public country: string | null,
    public identificationCode: string | null = null
  ) {}
}
