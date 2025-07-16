import {Builder, ByteBuffer} from "flatbuffers";
import {Practice} from "../kaatarina/flatabo/practice";

async function kaatarinaGetHello() {
    const url = 'http://localhost:8080/hello';
    fetch('/hello')
        .then(res => res.arrayBuffer())
        .then(buf => {
            const bytes = new Uint8Array(buf);
            const bb = new ByteBuffer(bytes);
            const practice = Practice.getRootAsPractice(bb);
            console.log(practice.age());
        })
        .catch(err => {
            console.error("FlatBuff err; ", err);
        });
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
