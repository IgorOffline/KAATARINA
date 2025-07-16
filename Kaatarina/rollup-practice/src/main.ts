import {Builder, ByteBuffer} from "flatbuffers";
import {Practice} from "./kaatarina/flatabo/practice";

const builder = new Builder(1024);

const name = builder.createString("Kaatarina");

Practice.startPractice(builder);
Practice.addId(builder, 1);
Practice.addAge(builder, 18);
Practice.addName(builder, name);
Practice.addPractice(builder, true);
const serde = Practice.endPractice(builder);

builder.finish(serde);

const buf = builder.asUint8Array();

const practiceBuffer = new ByteBuffer(buf);
const practice = Practice.getRootAsPractice(practiceBuffer);

console.log(`practice.age()=${practice.age()}`);