import {ByteBuffer} from "flatbuffers";
import {Practice} from "../kaatarina/flatabo/practice";

const urlRenata1 = '/renata/1';

async function kaatarinaGetHello() {
    const response = await fetch(urlRenata1);
    const arrayBuffer = await response.arrayBuffer();
    const bytes = new Uint8Array(arrayBuffer);
    const bb = new ByteBuffer(bytes);

    const practice = Practice.getRootAsPractice(bb);

    console.log("practice.id()=", practice.id());
    console.log("practice.age()=", practice.age());
    console.log("practice.name()=", practice.name());
    console.log("practice.practice()=", practice.practice());
}

export function kaatarinaReady(fn: (this: Document, ev: Event) => any) {
    if (document.readyState !== 'loading') {
        kaatarinaGetHello().then(r => console.log('DONE kaatarinaGetHello()'));
    } else {
        document.addEventListener('DOMContentLoaded', fn);
    }
}

console.log('KAATARINA MAIN-TS');
