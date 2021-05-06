package com.struggle.jvm.instructions.constants.statik;

import com.struggle.jvm.instructions.base.BytecodeReader;
import com.struggle.jvm.instructions.base.Instruction;
import com.struggle.jvm.parse.constantpool.ConstantPool;
import com.struggle.jvm.parse.constantpool.impl.ConstantMemberRefInfo;
import com.struggle.jvm.rtda.StackFrame;

import java.util.Map;

/**
 * @author strugglesnail
 * @date 2021/5/5
 * @descc 获取指定类的静态域，并将其值压入栈顶
 */
public class GET_STATIC implements Instruction {

    int idx;

    private ConstantPool constantPool;

    public GET_STATIC(ConstantPool constantPool) {
        this.constantPool = constantPool;
    }

    @Override
    public void fetchOperands(BytecodeReader reader) {
        idx = reader.readShort();
    }

    @Override
    public void execute(StackFrame frame) {
        ConstantMemberRefInfo memberRefInfo = constantPool.getMemberRefInfo(idx);
        String className = memberRefInfo.className();
        Map<String, String> nameAndType = memberRefInfo.nameAndDescriptor();
        frame.getOperandStack().pushRef(className);
        frame.getOperandStack().pushRef(nameAndType);
    }
}
