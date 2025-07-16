import {ByteBuffer} from "flatbuffers";
import {Practice} from "../kaatarina/flatabo/practice";

async function kaatarinaGetHello() {
    const response = await fetch('/hello');
    const arrayBuffer = await response.arrayBuffer();
    const bytes = new Uint8Array(arrayBuffer);
    const bb = new ByteBuffer(bytes);

    const practice = Practice.getRootAsPractice(bb);

    console.log("ID=", practice.id());
    console.log("Age=", practice.age());
    console.log("Name=", practice.name());
    console.log("Practice flag=", practice.practice());
}

export function kaatarinaReady(fn: (this: Document, ev: Event) => any) {
    console.log('kaatarinaReady START');
    if (document.readyState !== 'loading') {
        kaatarinaGetHello().then(r => console.log('kaatarinaGetHello() DONE'));
    } else {
        document.addEventListener('DOMContentLoaded', fn);
    }
}

console.log('kaatarinaMain');
