package com.struggle.jvm.instructions.extended;


import com.struggle.jvm.instructions.base.BytecodeReader;
import com.struggle.jvm.instructions.base.Instruction;
import com.struggle.jvm.instructions.loads.aload.ALOAD;
import com.struggle.jvm.instructions.loads.dload.DLOAD;
import com.struggle.jvm.instructions.loads.fload.FLOAD;
import com.struggle.jvm.instructions.loads.iload.ILOAD;
import com.struggle.jvm.instructions.loads.lload.LLOAD;
import com.struggle.jvm.instructions.math.iinc.IINC;
import com.struggle.jvm.instructions.stores.astore.ASTORE;
import com.struggle.jvm.instructions.stores.dstore.DSTORE;
import com.struggle.jvm.instructions.stores.fstore.FSTORE;
import com.struggle.jvm.instructions.stores.istore.ISTORE;
import com.struggle.jvm.instructions.stores.lstore.LSTORE;
import com.struggle.jvm.rtda.StackFrame;

public class WIDE implements Instruction {

    private Instruction modifiedInstruction;

    @Override
    public void fetchOperands(BytecodeReader reader) {
        byte opcode = reader.readByte();
        switch (opcode){
            case 0x15:
                ILOAD inst_iload = new ILOAD();
                inst_iload.idx = reader.readShort();
                this.modifiedInstruction = inst_iload;
            case 0x16:
                LLOAD inst_lload = new LLOAD();
                inst_lload.idx = reader.readShort();
                this.modifiedInstruction = inst_lload;
            case 0x17:
                FLOAD inst_fload = new FLOAD();
                inst_fload.idx = reader.readShort();
                this.modifiedInstruction = inst_fload;
            case 0x18:
                DLOAD inst_dload = new DLOAD();
                inst_dload.idx = reader.readShort();
                this.modifiedInstruction = inst_dload;
            case 0x19:
                ALOAD inst_aload = new ALOAD();
                inst_aload.idx = reader.readShort();
                this.modifiedInstruction = inst_aload;
            case 0x36:
                ISTORE inst_istore = new ISTORE();
                inst_istore.idx = reader.readShort();
                this.modifiedInstruction = inst_istore;
            case 0x37:
                LSTORE inst_lstore = new LSTORE();
                inst_lstore.idx = reader.readShort();
                this.modifiedInstruction = inst_lstore;
            case 0x38:
                FSTORE inst_fstore = new FSTORE();
                inst_fstore.idx = reader.readShort();
                this.modifiedInstruction = inst_fstore;
            case 0x39:
                DSTORE inst_dstore = new DSTORE();
                inst_dstore.idx = reader.readShort();
                this.modifiedInstruction = inst_dstore;
            case 0x3a:
                ASTORE inst_astore = new ASTORE();
                inst_astore.idx = reader.readShort();
                this.modifiedInstruction = inst_astore;
            case (byte) 0x84:
                IINC inst_iinc = new IINC();
                inst_iinc.idx = reader.readShort();
                this.modifiedInstruction = inst_iinc;
            case (byte) 0xa9: // ret
                throw new RuntimeException("Unsupported opcode: 0xa9!");
        }
    }

    @Override
    public void execute(StackFrame frame) {
        this.modifiedInstruction.execute(frame);
    }
}
