export interface MachineGun {
    id?:number,
    name: string,
    photoUrl: string,
    description: string,
    amount: number,
    _links?:{
        self: {
        href: string
        },
        machineGun: {
        href: string
        }
    }
}
