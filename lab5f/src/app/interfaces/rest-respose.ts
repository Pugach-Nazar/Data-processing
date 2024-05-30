import { MachineGun } from "./machine-gun"

export interface RestRespose {
    _embedded:{
        machineGuns:MachineGun[]
    },
    _links: {
        self: {
          href: string
        },
        profile: {
          href: string
        }
    },
    page: {
        size: number,
        totalElements: number,
        totalPages: number,
        number: number
    }
}